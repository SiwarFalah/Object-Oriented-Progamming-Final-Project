package View;

import Listeners.ViewListenable;

public interface ProgramViewable {
	void registerListener(ViewListenable l);
}