package com.edteam1.smdb.Controllers;

import com.edteam1.smdb.base.BaseComponent;
import com.edteam1.smdb.domain.BaseModel;
import com.edteam1.smdb.service.BaseService;
import com.edteam1.smdb.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<T extends BaseModel> extends BaseComponent {
	protected abstract BaseService<T,Long> getBaseService();

	@GetMapping
	public ResponseEntity<ApiResponse<List<T>>> findAll() {
		return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build(),
									HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<T>> get(@PathVariable Long id) {
		return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody T t) {
		return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(t)).build(), HttpStatus.CREATED);
	}

	@DeleteMapping
	public void delete(@Valid @RequestBody T t) {
		if (getBaseService().exists(t)) {
			getBaseService().delete(t);
		}
	}
}
