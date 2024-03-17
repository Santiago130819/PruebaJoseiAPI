package com.example.ApiTIpoCambio.Controller;

import com.example.ApiTIpoCambio.Model.TipoCambioModel;
import com.example.ApiTIpoCambio.Repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TipoCambioController {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @GetMapping(value="/all")
    public List<TipoCambioModel> todo(){
        return tipoCambioRepository.findAll();
    }
    @GetMapping(value="/consultacambio/{id}")
    public TipoCambioModel todo(@PathVariable long id){
        return tipoCambioRepository.findById(id).get();
    }
    @PostMapping(value="/api/registrarcambio")
    public String evaluaYRegistraCambio(@RequestBody TipoCambioModel tipoCambioModel){
        double montoConvertido;
        if(tipoCambioModel.getMonedaOrigen().equals("USD") && tipoCambioModel.getMonedaDestino().equals("PEN")){
            montoConvertido = tipoCambioModel.getMonto() * 3.69;
            tipoCambioModel.setMontoCambiado(montoConvertido);
            tipoCambioRepository.save(tipoCambioModel);
            return "Se grabo el cambio";
        } else if (tipoCambioModel.getMonedaOrigen().equals("PEN") && tipoCambioModel.getMonedaDestino().equals("USD")) {
            montoConvertido = tipoCambioModel.getMonto() * 0.27;
            tipoCambioModel.setMontoCambiado(montoConvertido);
            tipoCambioRepository.save(tipoCambioModel);
            return "Se grabo el cambio";
        }else {
            return "No se tiene mapeado el tipo de moneda indicado favor de intentar con USD o PEN";
        }
    }
    @PutMapping(value="/api/actualizarcambio/{id}")
    public String evaluaYRegistraCambio(@PathVariable long id, @RequestBody TipoCambioModel tipoCambioModel){
        TipoCambioModel updateCambio = tipoCambioRepository.findById(id).get();
        updateCambio.setUsuario(tipoCambioModel.getUsuario());
        updateCambio.setMonedaDestino(tipoCambioModel.getMonedaDestino());
        updateCambio.setMonedaOrigen(tipoCambioModel.getMonedaOrigen());
        updateCambio.setMonto(tipoCambioModel.getMonto());
        tipoCambioRepository.save(updateCambio);
        return "Se actualizo correctamente el registro";

    }

}
