package com.example.springreactivecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "[a-zA-ZА-Яа-яЁё0-9/]*", message = "Неверный формат")
    private String numContract;
    @Column("sum")
    @Digits(integer=17, fraction=4,message = "Неверный формат")
    private BigDecimal sum;
    @Column("comment")

    private String comment;



}
