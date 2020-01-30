package com.example.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Customer;
import com.example.repository.CustomerDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class UploadController {

	@Autowired
	private CustomerDTO customerDTO;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/upload-csv-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			// parse CSV file to create a list of `User` objects
			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				// create csv bean reader
				CsvToBean<Customer> csvToBean = new CsvToBeanBuilder<Customer>(reader).withType(Customer.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				// convert `CsvToBean` object to list of users
				List<Customer> customers = csvToBean.parse();

				// save users in DB
				for (int i = 0; i < customers.size(); i++) {
					Customer cust = new Customer();
					cust.setId(customers.get(i).getId());
					cust.setLastName(customers.get(i).getLastName());
					cust.setLocation(customers.get(i).getLocation());
					cust.setOutletName(customers.get(i).getOutletName());
					cust.setOutletType(customers.get(i).getOutletType());
					customerDTO.save(cust);
				}

				// save users list on model
				model.addAttribute("customers", customers);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}

		return "file-upload-status";
	}
}
