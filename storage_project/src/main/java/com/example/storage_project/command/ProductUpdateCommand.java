package com.example.storage_project.command;

import com.example.storage_project.MeasureUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductUpdateCommand {
    String name;
    MeasureUnit measureUnit;
    String shelfLife;
    double basicPrice;
}
