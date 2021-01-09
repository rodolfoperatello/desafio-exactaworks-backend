package br.com.exactaworks.desafio.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(description = "Details about the ExpenseRequest")
public class ExpenseRequest {

    @NotBlank(message = "The user's id cannot be null or empty")
    @Min(value = 1, message = "The user's ID cannot be less than 1")
    @ApiModelProperty(notes = "The user's ID")
    private Long userId;
    @NotBlank(message = "The expense's description cannot be null or empty")
    @ApiModelProperty(notes = "The expense's description")
    private String description;
    @NotNull(message = "The expense's value cannot be null or empty")
    @Min(value = 0, message = "The expense's value cannot be less than zero")
    @ApiModelProperty(notes = "The expense's value")
    private BigDecimal value;
    @NotBlank(message = "The expense's tag cannot be null or empty")
    private String tag;
    @NotBlank(message = "The expense's date and time cannot be null or empty")
    private String dateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
