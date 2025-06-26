package dto;

public class PerfumeWithScrollbar {
	
	    private Perfumes perfume;
	    private Scrollbar scrollbar;

	    public PerfumeWithScrollbar(Perfumes perfume, Scrollbar scrollbar) {
	        this.perfume = perfume;
	        this.scrollbar = scrollbar;
	    }

	    public Perfumes getPerfume() {
	        return perfume;
	    }

	    public Scrollbar getScrollbar() {
	        return scrollbar;
	    }

	    public void setPerfume(Perfumes perfume) {
	        this.perfume = perfume;
	    }

	    public void setScrollbar(Scrollbar scrollbar) {
	        this.scrollbar = scrollbar;
	    }
	}



