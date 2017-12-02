package com.oto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_ID")
	protected int cardId;
	@Column(name = "CARD_NBR")
	protected String cardNumber;
	@Column(name = "CARD_TYPE")
	protected String type;
	@Column(name = "EXPIRY_MONTH")
	protected int expiryMonth;
	@Column(name = "EXPIRY_YEAR")
	protected int expiryYear;
	protected int cvv;
	@Column(name = "NAME_ON_CARD")
	protected String nameOnCard;
	@Column(name = "ISSUED_DT")
	protected Date issuedDate;
	@ManyToOne
	@JoinColumn(name = "CARD_HOLDER_ID", unique = true, nullable = false)
	protected CardHolder holder;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public CardHolder getHolder() {
		return holder;
	}

	public void setHolder(CardHolder holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber
				+ ", type=" + type + ", expiryMonth=" + expiryMonth
				+ ", expiryYear=" + expiryYear + ", cvv=" + cvv
				+ ", nameOnCard=" + nameOnCard + ", issuedDate=" + issuedDate
				+ ", holder=" + holder + "]";
	}

}
