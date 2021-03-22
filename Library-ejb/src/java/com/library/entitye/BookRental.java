/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entitye;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Данил
 */
@Entity
@Table(name = "book_rental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookRental.findAll", query = "SELECT b FROM BookRental b")
    , @NamedQuery(name = "BookRental.findById", query = "SELECT b FROM BookRental b WHERE b.id = :id")
    , @NamedQuery(name = "BookRental.findByIdReader", query = "SELECT b FROM BookRental b WHERE b.idReader = :idReader")
    , @NamedQuery(name = "BookRental.findByIdBook", query = "SELECT b FROM BookRental b WHERE b.idBook = :idBook")
    , @NamedQuery(name = "BookRental.findByIdEmployeer", query = "SELECT b FROM BookRental b WHERE b.idEmployeer = :idEmployeer")
    , @NamedQuery(name = "BookRental.findByIssueDate", query = "SELECT b FROM BookRental b WHERE b.issueDate = :issueDate")
    , @NamedQuery(name = "BookRental.findByReturnDate", query = "SELECT b FROM BookRental b WHERE b.returnDate = :returnDate")
    , @NamedQuery(name = "BookRental.findByProcessingDate", query = "SELECT b FROM BookRental b WHERE b.processingDate = :processingDate")
    , @NamedQuery(name = "BookRental.findByStatus", query = "SELECT b FROM BookRental b WHERE b.status = :status")})
public class BookRental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_reader", referencedColumnName = "id")  
    private User idReader;
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book idBook;
    @Column(name = "id_employeer")
    private Integer idEmployeer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Column(name = "processing_date")
    @Temporal(TemporalType.DATE)
    private Date processingDate;
    @Column(name = "status")
    private Short status;

    public BookRental() {
    }

    public BookRental(Integer id) {
        this.id = id;
    }

    public BookRental( User idReader, Book idBook, Date issueDate) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.issueDate = issueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdReader() {
        return idReader;
    }

    public void setIdReader(User idReader) {
        this.idReader = idReader;
    }

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public Integer getIdEmployeer() {
        return idEmployeer;
    }

    public void setIdEmployeer(Integer idEmployeer) {
        this.idEmployeer = idEmployeer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookRental)) {
            return false;
        }
        BookRental other = (BookRental) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.entityes.BookRental[ id=" + id + " ]";
    }
    
}
