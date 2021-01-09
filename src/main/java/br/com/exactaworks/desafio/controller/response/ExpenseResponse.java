package br.com.exactaworks.desafio.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "Details about the ExpenseResponse")
public class ExpenseResponse {

    @ApiModelProperty(notes = "The unique ID of the expense")
    private Long id;
    @ApiModelProperty(notes = "The person's full name")
    private String fullName;
    @ApiModelProperty(notes = "The expense's name")
    private String description;
    @ApiModelProperty(notes = "The date and time when the expense was generated")
    private LocalDateTime dateTime;
    @ApiModelProperty(notes = "The expense's value")
    private BigDecimal value;
    @ApiModelProperty(notes = "The expense's tag")
    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
