package com.example.springreactivecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.Constraint;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("loc_contract")
public class LocContract {
    @Id

    private Long id;
    @Column("date_begin")
    @NonNull
    private LocalDate dateBegin;
    @Column("date_end")

    private LocalDate dateEnd;
    @Column("num_contract")
    @NonNull
    private String numContract;
    @Column("sum")

    private BigDecimal sum;
    @Column("comment")

    private String comment;



}
