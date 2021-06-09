package di.board;

public class BoardService {
	FileDao filefile;

	public void setFilefile(FileDao filefile) {
		this.filefile = filefile;
	}

	public void output() {
		filefile.insert();
		filefile.search();
		filefile.update();
		filefile.delete();
	}
}

