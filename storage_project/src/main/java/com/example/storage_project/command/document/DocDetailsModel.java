package com.example.storage_project.command.document;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsModel {
    Long products;
    Long measureUnits;
    Double quantities;

    Double price;
}
