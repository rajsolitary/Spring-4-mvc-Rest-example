/*******************************************************************************
 * Copyright 2017, ITradeNetwork, Inc. All Rights Reserved.
 * No part of this content may be used without ITradeNetwork express consent.
 ******************************************************************************/
package net.rajesh.spring.jasper.Dao;

public class JasperInputForm {

	private String noofYears;
	private static String rptFmt = "pdf33";

	public static String getRptFmt() {
		return rptFmt;
	}

	public void setRptFmt(final String rptFmt) {
		this.rptFmt = rptFmt;
	}

	public String getNoofYears() {
		return noofYears;
	}

	public void setNoofYears(final String noofYears) {
		this.noofYears = noofYears;
	}

}
