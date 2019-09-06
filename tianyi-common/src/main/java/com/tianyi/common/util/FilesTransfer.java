package filetransfer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 * 
 * ClassName: Files 
 * @Description: 用于转换java文件格式,文件内必须统一格式，否则会出现两次转换
 * @author Hens
 * @date 2019年7月9日
 */
public class FilesTransfer {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入需要改变编码格式的文件位置");
		String str = scan.nextLine();
		File file = new File(str);
		System.out.println("文件的初始编码");
		String bm1 = scan.nextLine();
		System.out.println("文件需要转换成的编码");
		String bm2 = scan.nextLine();
		getAllFiles(file, bm1, bm2);
		scan.close();
	}
	/**
	 *
	 * @param file 需要改变编码格式的文件位置
	 * @param bm1  初始编码
	 * @param bm2  需要转换成的编码
	 * @throws FileNotFoundException        无法找到文件异常
	 * @throws UnsupportedEncodingException 转换异常
	 * @throws IOException                  io流异常
	 */
	public static void getAllFiles(File file, String bm1, String bm2)throws FileNotFoundException, UnsupportedEncodingException, IOException {
		// 判断是否为文件夹
		if (file.isDirectory()) {
			File[] fileArray = file.listFiles();
			// 循环得到的descfile数组并转换格式
			for (File descfile : fileArray) {
				// 获得目标文件的名字
				String str = descfile.getPath();
				if (str.endsWith("java") & descfile.isFile()) {
					// 根据\\.分割目录，并命名为处理文件
					String[] s = str.split("\\.");
					String filecope = s[0] + "cope." + s[1];
					// 正在处理的文件路径
					System.out.println(filecope);
					File tempFile = new File(filecope);
					// 读取文件及编码格式
					InputStreamReader isr = new InputStreamReader(new FileInputStream(descfile), bm1);
					// 写入到临时文件tempFile改变编码格式
					OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(tempFile), bm2);
					int re = -1;
					while ((re = isr.read()) != -1) {
						osr.write(re);
					}
					isr.close();
					osr.close();
					// 读取临时文件及其编码格式
					InputStreamReader isrr = new InputStreamReader(new FileInputStream(tempFile), bm2);
					// 用临时文件覆盖目标文件
					OutputStreamWriter osrw = new OutputStreamWriter(new FileOutputStream(descfile), bm2);
					int r = -1;
					while ((r = isrr.read()) != -1) {
						osrw.write(r);
					}
					isrr.close();
					osrw.close();
					// 临时文件删除，则格式转换成功
					boolean d = tempFile.delete();
					System.out.println(str + "文件转换成utf-8成功:" + d);
				}
				getAllFiles(descfile, bm1, bm2);
			}
		}
	}

}
