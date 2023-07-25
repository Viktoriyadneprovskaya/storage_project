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
public class DocumentUpdateModel {
    List<DocDetailsUpdateModel> docDetailsSelected;
}
