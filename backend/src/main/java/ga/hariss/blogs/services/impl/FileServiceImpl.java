package ga.hariss.blogs.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ga.hariss.blogs.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// getting file name.
		String fileName = file.getOriginalFilename();

		// generating random file name.
		String generatedFileName = UUID.randomUUID().toString();
		fileName = generatedFileName.concat(fileName.substring(fileName.lastIndexOf(".")));

		String filePath = path + File.separator + fileName;

		// create new file object.
		File newFile = new File(path);

		// create folder if not exist.
		if (!newFile.exists()) {
			newFile.mkdir();
		}

		Files.copy(file.getInputStream(), Paths.get(filePath));

		return fileName;
	}

	@Override
	public InputStream getImage(String path, String fileName) throws FileNotFoundException {
		path = path + File.separator + fileName;
		InputStream inputStream = new FileInputStream(path);
		return inputStream;
	}

}
