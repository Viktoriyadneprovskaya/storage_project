package com.example.storage_project.command.document;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocumentModel {
    Long contractor;
    List<DocDetailsModel> docDetailsRows;

}
