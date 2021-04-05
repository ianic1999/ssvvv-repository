package Service.XMLFileService;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;

public class TemaLabXMLService extends AbstractXMLService<Integer, TemaLab>{
    private TemaLabXMLRepo xmlrepo;

    public TemaLabXMLService(TemaLabXMLRepo xmlrepo)  {
        super(xmlrepo);
    }

    public void prelungireTemaLab(String nr, String descr, String sl, String sp, int sc) throws ValidatorException {
        if(sc<= Integer.parseInt(sp)){
            String sln= Integer.toString(Integer.parseInt(sl)+1) ;
            String[] params={nr,descr,sln,sp};
            update(params);
        }

    }
    @Override
    protected TemaLab extractEntity(String[] params){
        int id = 0;
        int saptLim = 0;
        int saptPred = 0;
        try{
            id = Integer.parseInt(params[0]);
            saptLim = Integer.parseInt(params[2]);
            saptPred = Integer.parseInt(params[3]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Numerical Arguments");
        }
        return new TemaLab(id,params[1], saptLim, saptPred);
    }

}
