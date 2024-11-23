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
import br.edu.ifsul.gerenciador.de.bens.department.Department;
import br.edu.ifsul.gerenciador.de.bens.department.DepartmentRepository;

@RestController
@RequestMapping("asset")
@CrossOrigin(origins = "http://localhost:5173")
public class AssetController {

	@Autowired
	private AssetRepository repository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@PostMapping
	public void saveAsset(@RequestBody AssetRequestDTO data) {
		Department department = departmentRepository.findById(data.departmentId())
				.orElseThrow(() -> new RuntimeException("Department not found"));
		Asset assetData = new Asset(data, department);
		repository.save(assetData);
	}

	@GetMapping
	public List<AssetResponseDTO> getAll() {
		List<AssetResponseDTO> assetList = repository.findAll().stream().map(AssetResponseDTO::new).toList();
		return assetList;
	}
}
