package run;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置文件类
 * 
 * @author Administrator
 *
 */
public class Config {

	/**
	 * 项目路径
	 */
	public static String PROJECT_PATH = "";

	/**
	 * 根目录下，忽略的文件夹名或文件名
	 * 
	 * @return
	 */
	public static List<String> getIgnoreList() {
		List<String> ignoreList = new ArrayList<>();
		ignoreList.add(".git");
		ignoreList.add(".gitignore");
		ignoreList.add("unpackage");
		ignoreList.add("manifest.json");
		return ignoreList;
	}

	/**
	 * 要混淆文件的后缀
	 * 
	 * @return
	 */
	public static List<String> getConfusionFileExtensions() {
		List<String> ignoreList = new ArrayList<>();
		ignoreList.add("js");
		ignoreList.add("html");
		ignoreList.add("ttf");
		return ignoreList;
	}
}
