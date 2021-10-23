package com.HeladeriaSnowy.Service;

import com.HeladeriaSnowy.Interfaces.IReportes;
import com.HeladeriaSnowy.Interfaces.Service.IReporteService;
import com.HeladeriaSnowy.Model.ReportesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportesService implements IReporteService {

    @Autowired
    private IReportes reportesdb;

    @Override
    public List<ReportesModel> listarVentasClientes(){
        return (List<ReportesModel>) reportesdb.findAll();
    }
}
