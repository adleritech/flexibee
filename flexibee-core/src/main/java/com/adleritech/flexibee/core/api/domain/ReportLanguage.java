package com.adleritech.flexibee.core.api.domain;

public enum ReportLanguage {
	CS("cs"),
	SK("sk"),
	DE("de"),
	EN("en");

	private final String value;

	ReportLanguage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
