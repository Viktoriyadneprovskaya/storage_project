const editButton = document.getElementById('edit-btn')
const deleteButton = document.getElementById('delete-btn')

function addRow() {
    const products = [
        { productId: 1, name: "Marshmallow White pink" },
        { productId: 2, name: "Marshmallow Glazed" },
        { productId: 3, name: "Marshmallow White marmalade" },
        { productId: 4, name: "Marshmallow Mango" },
        { productId: 5, name: "Marshmallow Apple" },
        { productId: 6, name: "Marshmallow Vanilla" },
        { productId: 7, name: "Marshmallow Latte" },
        { productId: 8, name: "Marmalade Jelly-form" },
        { productId: 9, name: "Marmalade Bears" },
        { productId: 10, name: "Marmalade Slices" },
        { productId: 11, name: "Gingerbread European" },
        { productId: 12, name: "Gingerbread Ukrainian" },
        { productId: 13, name: "Gingerbread with apricot filling" },
        { productId: 14, name: "Biscuit Family " },
        { productId: 15, name: "Biscuit Rainbow" },

    ];

    const measureUnits = [
        { measureUnitId: 1, measureName: "kg" },
        { measureUnitId: 2, measureName: "pсs" },
    ];
    const table = document.getElementById("table");

    const row = document.createElement("div");
    row.className = "dynamic-line";

    let count = document.createElement("div");
    count.textContent = document.querySelectorAll(".dynamic-line").length;
    // length + 1;
    count.className = "count";
    row.appendChild(count);

    let productsSelect = document.createElement("select");
    productsSelect.className = "doc-input select1";
    productsSelect.name = "docDetailsRows["+(count.textContent)+"].products";
    productsSelect.required = true;

    products.forEach(function(products) {
        const option = document.createElement("option");
        option.value = products.productId;
        option.textContent = products.name;
        productsSelect.appendChild(option);
    });

    row.appendChild(productsSelect);

    const measureUnitsSelect = document.createElement("select");
    measureUnitsSelect.className = "doc-input select2";
    measureUnitsSelect.name = "docDetailsRows["+(count.textContent)+"].measureUnits";
    measureUnitsSelect.required = true;

    measureUnits.forEach(function(measureUnits) {
        const option = document.createElement("option");
        option.value = measureUnits.measureUnitId;
        option.textContent = measureUnits.measureName;
        measureUnitsSelect.appendChild(option);
    });

    row.appendChild(measureUnitsSelect);

    var quantitiesInput = document.createElement("input");
    quantitiesInput.type = "number";
    quantitiesInput.className = "doc-input input1";
    quantitiesInput.name = "docDetailsRows["+(count.textContent)+"].quantities";
    quantitiesInput.id = "quantity-input";
    quantitiesInput.required = true;
    row.appendChild(quantitiesInput);

    table.appendChild(row);
}

editButton.addEventListener('click', function (){
    const documentId = this.getAttribute('data-document-id');
    const url = `/entire_document/update?document_id=${documentId}`;
    window.location.href = url;
});

deleteButton.addEventListener('click', function (){
    const documentId = this.getAttribute('data-doc-delete-id');
    const url = `/documents/delete?id=${documentId}`;
    window.location.href = url;
});
