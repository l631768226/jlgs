package hsoft.yfzx.jlgs.utils.validation;

import java.util.List;

public abstract class AbstactBaseRec
{
    protected AutoValidation autoValidation;
    
    public AbstactBaseRec() 
    {
        this.autoValidation = new AutoValidation(this);
    }
    
    public boolean validation()
    {
        return this.autoValidation.validation(null);
    }
    
    public List<FailCause> getFailCauses()
    {
        return this.autoValidation.getFailCauses();
    }
    
}
