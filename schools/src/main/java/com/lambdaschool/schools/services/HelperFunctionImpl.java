package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.ValidationError;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "HelperFunction")
public class HelperFunctionImpl  implements HelperFunction
{
    @Override
    public List<ValidationError> getConstraintViolations(Throwable cause)
    {
        // constraint Violation Exceptions bundled in *cause* (e.g. email doesn't work, pw invalid, etc.)
        // i.e. cause.cause.cause
        while( (cause != null) &&  !(cause instanceof ConstraintViolationException))
        {
            cause = cause.getCause();
        }
        List<ValidationError> listVE = new ArrayList<>();

        if (cause != null)
        {
            ConstraintViolationException ex = (ConstraintViolationException) cause;  //typecast the ambiguous exception obj to CVE.
                                                                                     // feasible due to knowing that cause will be an exception
            for (ConstraintViolation cv : ex.getConstraintViolations())
            {
                ValidationError newVE = new ValidationError();

                newVE.setCode(cv.getInvalidValue().toString());
                newVE.setMessage(cv.getMessage());
                listVE.add(newVE);
            }
        }
        return  listVE;
    }
}
