package com.agile.supermarket.entities.enums;

public enum PaymentMethod {

	CASH(1), CREDIT_CARD(2), DEBT_CARD(3);

	private int code;

	PaymentMethod(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PaymentMethod valueOf(int code) {
		for (PaymentMethod value : PaymentMethod.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid AppointmentType code");
	}

	public void setCode(int code) {
		this.code = code;
	}
}
