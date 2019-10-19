package de.leonhard.storage.internal.base;

import de.leonhard.storage.internal.enums.FileType;
import java.io.File;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@SuppressWarnings({"WeakerAccess", "unused"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileTypeUtils {


	/**
	 * Add a give FileType extension to a String.
	 *
	 * @param path     the path whichnthe extension should be added to.
	 * @param fileType the FileType to be used.
	 * @return the path with the give FileType extension.
	 */
	public static String addExtension(String path, FileType fileType) {
		return path + "." + fileType;
	}

	/**
	 * Check whether a given File is of the given FileType.
	 *
	 * @param file     the File to be checked.
	 * @param fileType the FileType to be checked against.
	 * @return true if the File is of the given FileType, otherwise false.
	 */
	public static boolean isType(final File file, final FileType fileType) {
		return getFileType(file).equals(fileType);
	}

	/**
	 * Returns the FileType of a given File.
	 *
	 * @param file the given File.
	 * @return the FileType of the File.
	 */
	public static FileType getFileType(File file) {
		return getFileType(getExtension(file));
	}

	/**
	 * Returns the FileType Enum associated with the given extension.
	 *
	 * @param extension the extension to be checked.
	 * @return the FileType Enum of the give extension or null if no matching Enum exists.
	 */
	public static FileType getFileType(String extension) {
		if (extension.equalsIgnoreCase("json")) {
			return FileType.JSON;
		} else if (extension.equalsIgnoreCase("yml")) {
			return FileType.YAML;
		} else if (extension.equalsIgnoreCase("toml")) {
			return FileType.TOML;
		} else if (extension.equalsIgnoreCase("csv")) {
			return FileType.CSV;
		} else if (extension.equalsIgnoreCase("ls")) {
			return FileType.LIGHTNING;
		} else {
			return null;
		}
	}

	/**
	 * Returns the extension of a given File.
	 *
	 * @param file the File to be checked.
	 * @return the extension of the given File.
	 */
	public static String getExtension(File file) {
		return getExtension(file.getName());
	}

	/**
	 * Returns the extension of a given File.
	 *
	 * @param path the Path of the File to be checked.
	 * @return the extension of the given File.
	 */
	public static String getExtension(String path) {
		return path.lastIndexOf(".") > 0 ? path.substring(path.lastIndexOf(".") + 1) : "";
	}
}