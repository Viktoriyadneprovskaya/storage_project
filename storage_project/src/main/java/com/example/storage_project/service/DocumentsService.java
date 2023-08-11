package com.example.storage_project.service;

import com.example.storage_project.command.document.*;
import com.example.storage_project.dao.DocumentsDao;
import com.example.storage_project.model.MyOrganization;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.Document;
import com.example.storage_project.model.document.DocumentDetails;
import com.example.storage_project.model.document.InvoiceType;
import com.example.storage_project.model.product.MeasureUnit;
import com.example.storage_project.model.product.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentsService {
    private final DocumentsDao documentsDao;
    private final ProductService productService;
    private final DocDetailsService docDetailsService;
    private final MeasureUnitService measureUnitService;
    private final ContractorService contractorService;
    private final InvoiceTypeService invoiceTypeService;

    public DocumentsService(DocumentsDao documentsDao, ProductService productService, DocDetailsService docDetailsService, MeasureUnitService measureUnitService, ContractorService contractorService, InvoiceTypeService invoiceTypeService) {
        this.documentsDao = documentsDao;
        this.productService = productService;

        this.docDetailsService = docDetailsService;
        this.measureUnitService = measureUnitService;
        this.contractorService = contractorService;
        this.invoiceTypeService = invoiceTypeService;
    }

    public List<Document> getAllDocuments(Long invoiceType){
        return documentsDao.getAllDocuments(invoiceType);
    }
    public Document getDocumentById(Long docId){
        return documentsDao.getDocumentById(docId);
    }
    public void saveDocument(Document document) {
        documentsDao.saveDocument(document);
    }
    public void deleteDocumentById(Long id) {
        documentsDao.deleteDocumentById(id);
    }
    public DocumentUpdateCommand documentToDocumentUpdateCommand(Long documentId){
        Document document = getDocumentById(documentId);
        List<DocumentDetails> documentDetails = docDetailsService.getAllDocDetailsByDocumentId(documentId);
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        List<DocDetailsSelected> docDetailsSelectedList = new ArrayList<>();
        for (DocumentDetails documentDetails1 : documentDetails) {
            DocDetailsSelected docDetailsSelected = new DocDetailsSelected();
            docDetailsSelected.setId(documentDetails1.getId());
            docDetailsSelected.setSelectedMeasureUnit(documentDetails1.getUnit());
            docDetailsSelected.setSelectedProduct(documentDetails1.getProduct());
            docDetailsSelected.setSelectedQuantity(documentDetails1.getQuantity());
            docDetailsSelected.setPrice(documentDetails1.getPrice());
            docDetailsSelectedList.add(docDetailsSelected);
        }
        DocumentUpdateCommand documentUpdateCommand = DocumentUpdateCommand.builder()
                .id(document.getDocumentId())
                .contractor(document.getContractor())
                .myOrganization(contractorService.getMyOrganization())
                .docDetailsSelected(docDetailsSelectedList)
                .products(products)
                .measureUnits(measureUnits)
                .creationDate(document.getCreationDate())
                .invoiceType(document.getInvoiceType())
                .documentId(document.getDocumentId())
                .build();
        return documentUpdateCommand;
    }
    public DocumentCommand loadNewDocument(Long invoiceType){
        List<Contractors> contractors = contractorService.getAllContractors(invoiceType);
        MyOrganization myOrganization = contractorService.getMyOrganization();
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        DocDetailsRow docDetailsRow = DocDetailsRow.builder()
                .products(products)
                .measureUnits(measureUnits)
                .build();
        List<DocDetailsRow> docDetailsRows = List.of(docDetailsRow);
        DocumentCommand documentCommand = DocumentCommand.builder()
                .contractors(contractors)
                .myOrganization(myOrganization)
                .docDetailsRows(docDetailsRows)
                .build();
        return documentCommand;
    }

    public Document savaNewSalesDocument(Long invoice_type, DocumentModel documentModel){
        Contractors contractor = contractorService.getContractorById(documentModel.getContractor());
        MyOrganization myOrganization = contractorService.getMyOrganization();
        InvoiceType invoiceType = invoiceTypeService.getInvoiceTypeById(invoice_type);

        Document document = Document.builder()
                .creationDate(LocalDate.now())
                .contractor(contractor)
                .priceType(contractor.getPriceType())
                .myOrganization(myOrganization)
                .invoiceType(invoiceType)
                .build();
        saveDocument(document);
        Document savedDocument = getDocumentById(document.getDocumentId());

        List<DocDetailsModel> docDetailsModels = documentModel.getDocDetailsRows();
        for (DocDetailsModel docDetailsModel : docDetailsModels) {
            Product product = productService.getProductById(docDetailsModel.getProducts());
            double price = product.getBasicPrice() - (product.getBasicPrice() * contractor.getPriceType().getChargePercent() / 100);
            double sum = price * docDetailsModel.getQuantities();
            MeasureUnit measureUnit = measureUnitService.getMeasureUnitById(docDetailsModel.getMeasureUnits());
            DocumentDetails documentDetails = DocumentDetails.builder()
                    .product(product)
                    .unit(measureUnit)
                    .quantity(docDetailsModel.getQuantities())
                    .price(price)
                    .sum(sum)
                    .document(savedDocument)
                    .build();
            docDetailsService.saveDocumentDetails(documentDetails);
        }
        return document;
    }
    public Document savaNewInputDocument(Long invoice_type, DocumentModel documentModel){
        Contractors contractor = contractorService.getContractorById(documentModel.getContractor());
        LocalDate date = LocalDate.now();
        MyOrganization myOrganization = contractorService.getMyOrganization();
        InvoiceType invoiceType = invoiceTypeService.getInvoiceTypeById(invoice_type);

        Document document = Document.builder()
                .creationDate(date)
                .contractor(contractor)
                .priceType(contractor.getPriceType())
                .myOrganization(myOrganization)
                .invoiceType(invoiceType)
                .build();
        saveDocument(document);
        Document savedDocument = getDocumentById(document.getDocumentId());

        List<DocumentDetails> documentsDetails = new ArrayList<>();
        List<DocDetailsModel> docDetailsModels = documentModel.getDocDetailsRows();
        for (DocDetailsModel docDetailsModel : docDetailsModels) {

            Product product = productService.getProductById(docDetailsModel.getProducts());
            double price = docDetailsModel.getPrice();
            double sum = price * docDetailsModel.getQuantities();
            MeasureUnit measureUnit = measureUnitService.getMeasureUnitById(docDetailsModel.getMeasureUnits());
            DocumentDetails documentDetails = DocumentDetails.builder()
                    .product(product)
                    .unit(measureUnit)
                    .quantity(docDetailsModel.getQuantities())
                    .price(price)
                    .sum(sum)
                    .document(savedDocument)
                    .build();
            documentsDetails.add(documentDetails);
        }
        for (DocumentDetails documentDetails : documentsDetails) {
            docDetailsService.saveDocumentDetails(documentDetails);
        }
        return document;
    }
}
