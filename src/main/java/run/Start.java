package run;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Start {

	public static void main(String[] args) {
		List<String> ignoreList = Config.getIgnoreList();
		File project = new File(Config.PROJECT_PATH);
		// 列出项目根路径下每一项File，是文件或文件夹
		File[] listFiles = project.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// 项目根路径忽略File项
				for (String ignoreFileName : ignoreList) {
					if (name.equals(ignoreFileName)) {
						return false;
					}
				}
				return true;
			}
		});
		// 要混淆的结果文件集合
		List<File> fileList = new ArrayList<>();
		List<String> confusionFileExtensions = Config.getConfusionFileExtensions();
		// 遍历所有根目录文件夹
		for (File each : listFiles) {
			// 根目录文件全部加入
			if (each.isFile()) {
				fileList.add(each);
			} else {
				// 如果是文件夹，递归遍历里面每个文件，过滤出指定后缀的
				fileList.addAll(FileUtils.listFiles(each,
						confusionFileExtensions.toArray(new String[confusionFileExtensions.size()]), true));
			}
		}
		// 遍历结果输出
		for (int i = 0; i < fileList.size(); i++) {
			File file = fileList.get(i);
			String relativePath = file.getPath().substring(Config.PROJECT_PATH.length() + 1);
			relativePath = relativePath.replace("\\", "/");
			System.out.print("\"" + relativePath + "\": {}");
			if (i != fileList.size() - 1) {
				System.out.println(",");
			}
		}
	}

}
