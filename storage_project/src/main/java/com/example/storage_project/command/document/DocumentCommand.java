package com.example.storage_project.command.document;

import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.MyOrganization;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocumentCommand {
    List<Contractors> contractors;
    MyOrganization myOrganization;
    List<DocDetailsRow> docDetailsRows;
}
