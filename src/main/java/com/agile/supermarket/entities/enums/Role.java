package com.agile.supermarket.entities.enums;

public enum Role {

	ADMIN(1, "ROLE_ADMIN"), CASHIER(2, "ROLE_CASHIER");

	private int code;
	private String description;

	private Role(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Role valueOf(Integer code) {

		if (code == null) {
			return null;
		}

		for (Role x : Role.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid AppointmentType code " + code);
	}

	public void setCode(int code) {
		this.code = code;
	}
}
