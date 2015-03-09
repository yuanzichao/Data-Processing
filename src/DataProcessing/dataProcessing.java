package DataProcessing;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * @author yuan
 *
 * @date 2015��02��26�� ����10:40:19
 */
public class dataProcessing {

	/**
	 * Name: main
	 * Description: 
	 * @param args
	 *
	 * @author yuan
	 * @date 2015��02��26�� ����10:40:19
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
				//Sheet(���������)����Excel������½ǵ�Sheet1,Sheet2,Sheet3���ڳ����� 
				//Sheet���±��Ǵ�0��ʼ�� 
				//��ȡ��һ��Sheet�� 
				Sheet sheet = book.getSheet(0); 
				Cell cell = null;//���ǵ�����Ԫ��
			    //��ʼѭ����ȡ�� cell ������ݣ����ﶼ�ǰ�String��ȡ,Ϊ��ʡ�£�����ɰ�ʵ��������ȡ�����߶���String��ȡ,Ȼ���������Ҫǿ��ת��һ�¡�
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
//					System.out.println("");//��ÿ�е��ַ�����һ��String���͵ļ��ϱ��档
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
