public class PopUp {
    private PopUpArgent popUpArgent;
    private PopUpEmprunt popUpEmprunt;

    public PopUp(PopUpArgent popUpArgent, PopUpEmprunt popUpEmprunt) {
        this.popUpArgent = popUpArgent;
        this.popUpEmprunt = popUpEmprunt;
    }

    public PopUpArgent getPopUpArgent() { return popUpArgent; }

    public PopUpEmprunt getPopUpEmprunt() { return popUpEmprunt; }
}
