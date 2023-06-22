package com.example.storage_project.command;
import com.example.storage_project.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsCommand {
    private Long id;
    private int number;
    private Product product;
    private MeasureUnit unit;
    private double quantity;
    private double price;//метод, который получает цену с учетом прайстайп и контрактортайп
    private double sum;
    private Document document;



    public static DocDetailsCommand docDetailToCommand(DocumentDetails documentDetails) {
        return DocDetailsCommand.builder()
                .id(documentDetails.getId())
                .product(documentDetails.getProduct())
                .unit(documentDetails.getUnit())
                .quantity(documentDetails.getQuantity())
                .price(documentDetails.getPrice())
                .sum(documentDetails.getSum())
                .document(documentDetails.getDocument())
                .build();
    }

    public static List<DocDetailsCommand> DocDetailsToCommand(List<DocumentDetails> documentDetails) {
        List<DocDetailsCommand> detailsCommand = new ArrayList<>();
        for (int i = 0; i < documentDetails.size(); i++) {
            DocDetailsCommand command = docDetailToCommand(documentDetails.get(i));
            command.setNumber(i + 1);
            detailsCommand.add(command);
        }
        return detailsCommand;
    }
}
