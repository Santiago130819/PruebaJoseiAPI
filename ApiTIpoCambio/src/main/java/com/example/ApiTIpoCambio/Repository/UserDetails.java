package com.example.ApiTIpoCambio.Repository;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    //Collection<? extends GrantedAuthority> getAuthorities();
    String getUsername();
}
