package br.com.linceit.stella.service.bucket;

import java.io.File;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class StellaBucket {

	private AWSCredentials aws;
	private AmazonS3 s3client;
	private String bucketName = "stella-bucket";

	public StellaBucket() {
		String accessKey = System.getenv("AWS_S3_STELLA_ACCESS_KEY");
		String secretKey = System.getenv("AWS_S3_STELLA_SECRET_KEY");
		aws = new BasicAWSCredentials(accessKey, secretKey);
		configureClient();
		checkClient();
	}
	
	private void configureClient() {
		s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(aws))
				.withRegion(Regions.US_EAST_1).build();
	}

	private void checkClient() {
		if (s3client.doesBucketExist(bucketName)) {
			System.out.println("Bucket encontrado");
			return;
		}
	}

	public void uploadFile(File file) {
		s3client.putObject(bucketName, file.getName(), file);
	}

	public String readFile(String fileName) throws Exception {
		S3Object s3object = s3client.getObject(bucketName, fileName);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		byte[] byteArray = IOUtils.toByteArray(inputStream);
		return new String(byteArray != null ? byteArray : "".getBytes(), "UTF-8");
	}

	/*
	 * public static void main(String[] args) { StellaBucket stellaBucket = new
	 * StellaBucket(); stellaBucket.uploadFile(new
	 * File("C:\\conteudo\\50911544-6d93-4da4-abae-eaa71d4e9d60.txt")); try {
	 * System.out.println(stellaBucket.readFile(
	 * "50911544-6d93-4da4-abae-eaa71d4e9d60.txt")); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

}
