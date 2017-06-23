package net.rajesh.spring.jasper.resource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.rajesh.spring.jasper.Dao.JasperInputForm;
import net.rajesh.spring.jasper.Dao.JasperReportDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@RestController
public class JasperReportResource {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	public String generateReport()
			throws JRException, IOException, NamingException {

		String reportFileName = "JREmp1";
		JasperReportDAO jrdao = new JasperReportDAO();

		Connection conn = null;

		try {
			conn = jrdao.getConnection();

			String rptFormat = JasperInputForm.getRptFmt();
			String noy = "9";

			System.out.println("rpt format " + rptFormat);
			System.out.println("no of years " + noy);

			HashMap<String, Object> hmParams = new HashMap<String, Object>();

			hmParams.put("noy", new Integer(noy));

			hmParams.put("Title", "Employees working more than " + noy + " Years");

			JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);

			if (rptFormat.equalsIgnoreCase("html")) {

				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);
				jrdao.generateReportHtml(jasperPrint, request, response);
			}

			else if (rptFormat.equalsIgnoreCase("pdf")) {

				jrdao.generateReportPDF(response, hmParams, jasperReport, conn);

			}

		} catch (SQLException sqlExp) {
			System.out.println("Exception::" + sqlExp.toString());
		} finally {
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

}
