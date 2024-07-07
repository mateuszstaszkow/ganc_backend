package com.ganc_backend.inquiries.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.ganc_backend.inquiries.model.Inquiry;
import com.ganc_backend.inquiries.repository.InquiryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Transactional
    public Mono<Inquiry> createInquiry(Inquiry inquiry) {
        return Mono.just(inquiryRepository.save(inquiry));
    }

    public Flux<Inquiry> getAllInquiries() {
        List<Inquiry> inquiries = inquiryRepository.findAll();
        return Flux.fromIterable(inquiries);
    }

    public Mono<Inquiry> getInquiryById(Long id) {
        return Mono.justOrEmpty(inquiryRepository.findById(id));
    }

    @Transactional
    public Mono<Inquiry> updateInquiry(Long id, Inquiry inquiry) {
        return inquiryRepository.findById(id)
                .map(existingInquiry -> {
                    existingInquiry.setEmail(inquiry.getEmail());
                    existingInquiry.setName(inquiry.getName());
                    existingInquiry.setMessage(inquiry.getMessage());
                    return inquiryRepository.save(existingInquiry);
                }).map(Mono::just).orElse(Mono.empty());
    }

    @Transactional
    public Mono<Void> deleteInquiry(Long id) {
        inquiryRepository.deleteById(id);
        return Mono.empty();
    }
}
