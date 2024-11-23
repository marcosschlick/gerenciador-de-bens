package br.edu.ifsul.gerenciador.de.bens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.gerenciador.de.bens.asset.Asset;
import br.edu.ifsul.gerenciador.de.bens.asset.AssetRepository;
import br.edu.ifsul.gerenciador.de.bens.asset.AssetRequestDTO;
import br.edu.ifsul.gerenciador.de.bens.asset.AssetResponseDTO;

@RestController
@RequestMapping("asset")
@CrossOrigin(origins = "http://localhost:5173")
public class AssetController {

	@Autowired
	private AssetRepository repository;

	@CrossOrigin(origins = "*0", allowedHeaders = "*")
	@PostMapping
	public void saveAsset(@RequestBody AssetRequestDTO data) {
		Asset assetData = new Asset(data);
		repository.save(assetData);
		return;
	}

	@CrossOrigin(origins = "*0", allowedHeaders = "*")
	@GetMapping
	public List<AssetResponseDTO> getAll() {
		List<AssetResponseDTO> assetList = repository.findAll().stream().map(AssetResponseDTO::new).toList();
		return assetList;
	}

}
