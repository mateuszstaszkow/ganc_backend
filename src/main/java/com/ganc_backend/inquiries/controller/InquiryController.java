package com.ganc_backend.inquiries.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.ganc_backend.inquiries.model.Inquiry;
import com.ganc_backend.inquiries.service.InquiryService;

@RestController
@RequestMapping("/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public Mono<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.createInquiry(inquiry);
    }

    @GetMapping
    public Flux<Inquiry> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/{id}")
    public Mono<Inquiry> getInquiryById(@PathVariable Long id) {
        return inquiryService.getInquiryById(id);
    }

    @PutMapping("/{id}")
    public Mono<Inquiry> updateInquiry(@PathVariable Long id, @RequestBody Inquiry inquiry) {
        return inquiryService.updateInquiry(id, inquiry);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteInquiry(@PathVariable Long id) {
        return inquiryService.deleteInquiry(id);
    }
}
