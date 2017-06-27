package com.mvcapp1.services;

import java.io.File;
import java.util.List;

import com.mvcapp1.controllerpackage.UserData;

public interface FileUploadInterface {

	public Boolean isFileExists(File file);
    public List<UserData> readContent(File file) throws Exception;
}
