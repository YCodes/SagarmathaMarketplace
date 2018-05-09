package com.sagarmatha.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BTransaction")
public class BTransaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String srcCardNo;
    
    private String dstCardNo;
    
    @Column(name = "TxnAmount", nullable = false)
    private double transactionAmount;
    
    @Column(name = "AblAmount", nullable = false)
    private double availableAmount;
    
  
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public BTransaction() {
    }

    public BTransaction(String srcCardNo, String dstCardNo, Double transactionAmount, Double availableAmount) {
        this.srcCardNo = srcCardNo;
        this.dstCardNo = dstCardNo;
        this.transactionAmount = transactionAmount;
        this.availableAmount = availableAmount;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrcCardNo() {
        return srcCardNo;
    }

    public void setSrcCardNo(String srcCardNo) {
        this.srcCardNo = srcCardNo;
    }

    public String getDstCardNo() {
        return dstCardNo;
    }

    public void setDstCardNo(String dstCardNo) {
        this.dstCardNo = dstCardNo;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

	@Override
	public String toString() {
		return "BTransaction [id=" + id + ", srcCardNo=" + srcCardNo + ", dstCardNo=" + dstCardNo
				+ ", transactionAmount=" + transactionAmount + ", availableAmount=" + availableAmount + ", createdAt="
				+ createdAt + "]";
	}

}
