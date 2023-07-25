package com.example.storage_project.command.document;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsUpdateModel {
    Long id;
    Long products;
    Long measureUnits;
    double quantities;
    double price;
}
