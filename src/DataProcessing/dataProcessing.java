package DataProcessing;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * @author yuan
 *
 * @date 2015年02月26日 下午10:40:19
 */
public class dataProcessing {

	/**
	 * Name: main
	 * Description: 
	 * @param args
	 *
	 * @author yuan
	 * @date 2015年02月26日 下午10:40:19
	 */
	 public static void main(String[] args) 
		{
			Workbook book=null;
			
			//Flags
			int ones = 0;
			int changes = 0;
			try 
			{ 
				InputStream is = new FileInputStream("test/outputData.xls"); 
//				InputStream is = new FileInputStream("test/outputData_Light.xls"); 
//				InputStream is = new FileInputStream("test/outputData_Maid_Light.xls"); 
//				InputStream is = new FileInputStream("test/outputData_Maid_Normal.xls"); 
//				InputStream is = new FileInputStream("test/outputData_Normal.xls"); 

				book = Workbook.getWorkbook(is); 
				//Sheet(术语：工作表)就是Excel表格左下角的Sheet1,Sheet2,Sheet3但在程序中 
				//Sheet的下标是从0开始的 
				//获取第一张Sheet表 
				Sheet sheet = book.getSheet(0); 
				Cell cell = null;//就是单个单元格
			    //开始循环，取得 cell 里的内容，这里都是按String来取,为了省事，具体可按实际类型来取。或者都按String来取,然后根据你需要强制转换一下。
				for (int i=1; i<sheet.getColumns(); i++) 
				{
					String flag = "0";
					for (int j=1; j<sheet.getRows(); j++) 
					{
						cell = sheet.getCell(i, j);
						
						String value = cell.getContents();
						
						if(value == "1" || value.equalsIgnoreCase("1")){
							ones += 1;
						}
						
						
						if(value != flag && !value.equalsIgnoreCase(flag)){
							if(flag == "0" || flag.equalsIgnoreCase("0")){
								changes += 1;
							}
							
							flag = value;
							
						}
					}
//					System.out.println("");//将每行的字符串用一个String类型的集合保存。
				}
				
				System.out.println("Ones = " + ones + "; Changes = " + changes);
				
			}
			catch(Exception e) 
			{ 
				System.out.println(e); 
			}
			finally
			{ 
				book.close(); 
			}
			
		}

}
