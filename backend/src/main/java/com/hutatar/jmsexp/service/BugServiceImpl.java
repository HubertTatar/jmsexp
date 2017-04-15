package com.hutatar.jmsexp.service;

import com.hutatar.jmsexp.domain.Bug;
import com.hutatar.jmsexp.dto.BugDto;
import com.hutatar.jmsexp.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Override
    public List<BugDto> list() {
        return dtosFromList(bugRepository.findAll());
    }

    @Override
    public BugDto find(BigInteger id) {
        return domainToDto(bugRepository.getOne(id));
    }

    @Override
    public void update(BugDto bugDto) {
        bugRepository.save(dtoToDomain(bugDto));
    }

    @Override
    public BugDto create(BugDto bugDto) {
        Bug save = bugRepository.save(dtoToDomain(bugDto));
        return domainToDto(save);
    }

    private Bug dtoToDomain(BugDto dto) {
        return Bug.builder()
                .id(dto.getId())
                .createdBy(dto.getCreatedBy())
                .description(dto.getDescription())
//                .createdDate(Instant.ofEpochMilli(dto.getCreatedDate()).atZone(ZoneId.systemDefault()).toLocalDateTime())
//                .modificationDate(Instant.ofEpochMilli(dto.getModificationDate()).atZone(ZoneId.systemDefault()).toLocalDateTime())
                .severity(dto.getSeverity())
                .status(dto.getStatus())
                .title(dto.getTitle())
                .build();
    }

    private List<BugDto> dtosFromList(List<Bug> all) {
        return all.stream().map(b -> domainToDto(b)).collect(Collectors.toList());
    }

    private BugDto domainToDto(Bug b) {
        return BugDto.builder()
                .id(b.getId())
                .modificationDate(b.getModificationDate())
                .createdDate(b.getCreatedDate())
                .createdBy(b.getCreatedBy())
                .description(b.getDescription())
                .title(b.getTitle())
                .severity(b.getSeverity())
                .status(b.getStatus())
                .updatedBy(b.getUpdatedBy())
                .build();

    }
}
