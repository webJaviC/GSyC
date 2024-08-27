package cons.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cons.dataAccess.ICalidadRepo;
import cons.dataAccess.IPalletRepo;
import cons.dataAccess.IRemitoRepo;
import cons.entities.Calidad;
import cons.entities.Pallet;
import cons.entities.Remito;

@Service
public class FileService {
	@Value("C:\\Users\\HP\\git\\remitoTxt\\")
    private String folderPath;
    
    @Autowired
    private IRemitoRepo remitoRepository;
    @Autowired
    private IPalletRepo palletRepository;
    @Autowired
    private ICalidadRepo calidadRepository;
    
    public void readAndPersistFile(String fileName) {
        File file = new File(folderPath + fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Remito remito = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (remito == null || !remito.getFecha().equals(LocalDate.parse(data[0]))) {
                    // Crear nuevo remito
                    remito = new Remito();
                    remito.setFecha(LocalDate.parse(data[0]));
                    remitoRepository.save(remito);
                }
                Pallet pallet = new Pallet();
                pallet.setGramaje(data[1]);
                pallet.setKilosNeto(Double.parseDouble(data[2]));
                pallet.setKilosBruto(Double.parseDouble(data[3]));
                pallet.setLargo(Double.parseDouble(data[4]));
                pallet.setAncho(Double.parseDouble(data[5]));
                
                // Buscar o crear calidad
                Calidad calidad = calidadRepository.findByName(data[6]);
                if (calidad == null) {
                    calidad = new Calidad();
                    calidad.setNombre(data[6]);
                    calidadRepository.save(calidad);
                }
                pallet.setCalidad(calidad);
                
                pallet.setRemito(remito);
                palletRepository.save(pallet);
                remito.getPallets().add(pallet);
            }
        } catch (IOException e) {
            // Manejar excepción
        }
    }
}