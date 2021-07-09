package co.com.labsphanter.invoice.service;

import co.com.labsphanter.invoice.object.model.Table;
import co.com.labsphanter.invoice.repository.TableRepository;

import co.com.labsphanter.invoice.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public Table save(Table table) {

        table.setId(Utilities.generationId());
        tableRepository.save(table);
        return table;
    }

    public Table update(Table table) {
        tableRepository.save(table);
        return table;
    }

    public Table findById(String id) {
        return Optional.ofNullable(
                tableRepository.findById(id))
                .get()
                .orElse(new Table());
    }

    public List<Table> findAll() {
        return tableRepository.findAll();
    }

}
