public class TableReader {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.docx");
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			Iterator bodyElementIterator = xdoc.getBodyElementsIterator();
			while (bodyElementIterator.hasNext()) {
				IBodyElement element = bodyElementIterator.next();

				if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
					List tableList = element.getBody().getTables();
					for (XWPFTable table : tableList) {
						System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
						for (int i = 0; i < table.getRows().size(); i++) {

							for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
								System.out.println(table.getRow(i).getCell(j).getText());
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}