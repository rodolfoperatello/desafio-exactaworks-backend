package br.com.exactaworks.desafio.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity userEntity;
    private String description;
    private LocalDateTime dateTime;
    private BigDecimal value;
    private String tag;

    public ExpenseEntity(){
    }

    public ExpenseEntity(UserEntity userEntity, String description, BigDecimal value, String tag, LocalDateTime dateTime) {
        this();
        this.userEntity = userEntity;
        this.description = description;
        this.value = value;
        this.tag = tag;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", value=" + value +
                ", tag='" + tag + '\'' +
                '}';
    }
}
