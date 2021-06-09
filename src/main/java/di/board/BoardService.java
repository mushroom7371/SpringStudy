package di.board;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardService {

//
//	public void setFilefile(FileDao filefile) {
//		this.filefile = filefile;
//	}
//

	@Autowired
	FileDao filefile;
	@Autowired
	BoardDao boardboard; 

	public void output() {
		filefile.insert();
		filefile.search();
		filefile.update();
		filefile.delete();
	}
}

