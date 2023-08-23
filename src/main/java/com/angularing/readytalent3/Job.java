package com.angularing.readytalent3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String company;
    private String type;
    private Integer salary;
    private LocalDate closingDate;
    private Integer vacancies;

    protected Job(){

    }

    Job(String title, String company, String type, Integer salary, LocalDate closingDate, Integer vacancies){
        this.title = title;
        this.company = company;
        this.type = type;
        this.salary = salary;
        this.closingDate = closingDate;
        this.vacancies = vacancies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public String toString(){
        return String.format("Job[id=%d, title='%s', company='%s', type='%s', salary='%d', closingDate='%s', vacancies='%d',]",
                id, title, company, type, salary, closingDate.toString(), vacancies);
    }
}
