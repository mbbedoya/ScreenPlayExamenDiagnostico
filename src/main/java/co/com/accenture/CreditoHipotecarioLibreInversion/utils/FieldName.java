package co.com.accenture.CreditoHipotecarioLibreInversion.utils;

public enum FieldName {

	TYPE_OF_ID(0), ID_NUMBER(1);

	private int field;

	FieldName(int value) {
		field = value;
	}

	public int getValue() {

		return field;
	}
}
